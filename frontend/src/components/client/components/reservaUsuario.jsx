import React, { useEffect, useState } from "react";
import { updateMesa } from '../../../services/mesa'
import { deleteReservaItem, getReservaList } from "../../../services/reserva";
import {
  getShoppingList,
  getSaleList,
  deleteShoppingItem,
  generateSale,
} from "../../../services/shoppingCart";

function ReservaUsuario() {
  let [number, setNumber] = useState(0);
  useEffect(() => {
    let shouldUpdate = true;
    const getUserCart = () => {
      const item = localStorage.getItem("number");
      if (item) {
        setNumber(parseInt(item));
      }
    };
    if (shouldUpdate) {
      getUserCart();
    }
    window.addEventListener("storage", getUserCart);
    return () => {
      shouldUpdate = false;
    };
  }, [number]);
  const [productList, setProductList] = useState([]);
  const [salesList, setSalesList] = useState([]);
  const [open, setOpen] = useState(false);
  const getList = () => {
    getReservaList({ setProductList });
  };
  const getSales = () => {
    getSaleList({ setSalesList });
  };
  useEffect(() => {
    getList();
    getSales();
  }, []);
  const deleteItem = (itemId) => {
    deleteReservaItem({ itemId }).then(() => {
        
        getReservaList({ setProductList });
    });
  };
  //   const calculateTotal = (items) => {
  //     let total = 0;
  //     items.forEach((item) => {
  //       total = total + item.amount * item.product.price;
  //     });
  //     return total;
  //   };
  const getDate = (date) => {
    return new Date(date).toLocaleDateString();
  };
  const confirmSale = () => {
    generateSale().then(() => {
      setOpen(true);
      getSales();
      getList();
      let number = 0;
      localStorage.setItem("number", number.toString());
      window.dispatchEvent(new Event("storage"));
    });
  };
  const closeFeedback = (event, reason) => {
    if (reason === "clickaway") {
      return;
    }
    setOpen(false);
  };

  const updateEstado = (id) => {
    console.log(id)
    const mesa = {
      id_mesa: id,
      estado: "Disponible",
    };
    updateMesa({mesa})
  } 

  return (
    <div className="max-w-[1440px] mx-auto overflow-x-auto relative shadow-xl sm:rounded-lg mb-10 mt-5">
      <h1 className="text-amber-600 font-bold text-4xl text-center mb-5">
        Mis Reservas
      </h1>
      <table className="w-full text-sm text-left text-black dark:text-black">
        <thead className="text-xs text-black uppercase bg-gray-50 dark:bg-amber-600 dark:text-black">
          <tr>
            <th scope="col" className="py-3 px-6">
              Numero Reserva
            </th>
            <th scope="col" className="py-3 px-6">
              Numero Mesa
            </th>
            <th scope="col" className="py-3 px-6">
              Fecha
            </th>
            <th scope="col" className="py-3 px-6">
              Estado
            </th>
            <th scope="col" className="py-3 px-6">
              <span className="sr-only">Edit</span>
            </th>
          </tr>
        </thead>
        {productList.map((item) => (
          <tbody key={item.id_reserva}>
            <tr className="bg-white border-b dark:bg-white dark:border-amber-600 hover:bg-gray-50 dark:hover:bg-amber-600">
              <th
                scope="row"
                className="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-black"
              >
                {item.id_reserva}
              </th>
              <td className="py-4 px-6">Mesa N°{item.mesa.id_mesa}</td>
              <td className="py-4 px-6">{getDate(item.fecha)}</td>
              {item.estado_reserva === "Cancelado" ? <td className="py-4 px-6">{item.estado_reserva}</td> : <td className="py-4 px-6">{item.mesa.estado}</td>}
              
              <td className="py-4 px-6 text-right">
                <a
                  className="font-medium text-white dark:text-black hover:underline cursor-pointer"
                  onClick={() => {deleteItem(item.id_reserva);updateEstado(item.mesa.id_mesa);}}
                >
                  Cancelar Reserva
                </a>
              </td>
            </tr>
          </tbody>
        ))}
      </table>
    </div>
  );
}

export default ReservaUsuario;
