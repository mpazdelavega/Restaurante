import React, { useEffect, useState } from 'react';
import { getUserDetails } from '../../../services/auth'
import { getAllMesas, updateMesa } from '../../../services/mesa'
import { addReserva } from '../../../services/reserva';
import { deleteReservaItem, getReservaList, updateReserva } from "../../../services/reserva";
import { ToastContainer, toast } from "react-toastify"
import "react-toastify/dist/ReactToastify.css"

function Mesa(props) {
  const [roles, setUserRole] = useState([{}])
  const [mesaList, setMesaList] = useState([])
  const [productList, setProductList] = useState([]);
  
  const [refresh, setRefresh] = useState(false)
  const [openModal, setOpenModal] = useState(false)
  const [showProductFeedback, setProductFeedback] = React.useState({ show: false, status: false, infoText: '' })

  useEffect(() => {
    getUserDetails({ setUserRole })
    getAllMesas({ setMesaList })
    getReservaList({ setProductList })
    getReservas()
  }, [refresh])

  const getList = () => {
    getReservaList({ setProductList });
  };

  const getReservas = () => {
    let reserva = '';
    let estado = '';
    let mesa = '';
    productList.forEach((item) => {
      reserva = item.client.id;
      estado = item.estado_reserva;
      mesa = item.mesa.id_mesa;
    });
    if(reserva === getIdClient()){
      return estado;
    }
    

    //return console.log("getReservas: " + reserva + " " + estado + " " + mesa);
    
  };

  const getIdClient = () => {
    let clientId = '';
    productList.forEach((item) => {
      clientId = item.client.id;
    });
    return clientId;
  };

  const handleOpenModal = () => setOpenModal(true)
  const closeProductFeedback = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setProductFeedback({ show: false });
  };

  const addMesa = (fechaToAdd, mesaToAdd) => {
    addReserva({ fechaToAdd, mesaToAdd })
    
    //updateMesa({mesa})
    //console.log(mesaToAdd, fechaToAdd)
  }

  const updateEstado = (id,fecha) => {
    console.log(id)
    const mesa = {
      id_mesa: id,
      estado: "Reservada",
      date: fecha,
    };
    updateMesa({mesa})
    //window.location.replace('');
    
  } 

  const notifyReserva = () => {
    toast.success('📅 Mesa reservada correctamente ', {
      position: "bottom-center",
      autoClose: 5000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: false,
      draggable: true,
      progress: undefined,
      theme: "dark",
      });
      
  }


  var today = new Date(),
  date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + (today.getDate() + 1);



  return (
    <div className='max-w-[1640px] m-auto px-4 py-12'>   
      <h1 className='text-amber-600 font-bold text-4xl text-center'>
        Mesas disponibles
      </h1>
      {/* Display foods */}
      <div className='grid grid-cols-2 lg:grid-cols-4 gap-6 pt-4'>
        {mesaList.map((item) => (
          <div
            key={item.id_mesa}
            className='border shadow-lg rounded-lg hover:scale-105 duration-300 '
          >
            
              
            <img
              src={item.tipo_mesa.foto}
              alt={item.tipo_mesa.descripcion}
              className='w-full h-[200px] object-cover rounded-t-lg '
            />

            
            <div className='flex justify-between px-2 py-4'>
              <p className='font-bold'>Mesa N°{item.tipo_mesa.id_tipo_mesa}</p>
              <p>
              <span className='bg-amber-600 text-white p-2 mr-2 rounded-full'>
                  {item.tipo_mesa.capacidad} Personas
                </span>
                {getReservas() === "Cancelado" || getReservas() === "" ? <button className='bg-amber-600 hover:bg-amber-900 transition-colors text-white p-1.5 rounded-full' onClick={() => {addMesa(date, item);updateEstado(item.id_mesa,item.date);notifyReserva();getReservas();}}>
                    Reservar
                </button>: <button className='bg-gray-600 text-gray-300 p-1.5 rounded-full disabled' >
                    Reservada
                </button>}
                
              </p>
            </div>
            <p className='font-bold text-center mb-5'>{item.date}</p>
            
          </div>
        ))}
        {/* {item.estado === "Disponible" || item.estado === "Cancelado" ? <button className='bg-amber-600 hover:bg-amber-900 transition-colors text-white p-1.5 rounded-full' onClick={() => {addMesa(date, item);updateEstado(item.id_mesa);notifyReserva();getReservas()}}>
                    Reservar
                </button>: <button className='bg-gray-600 text-gray-300 p-1.5 rounded-full disabled' >
                    Reservada
                </button>}
                
              </p>
            </div>
            
          </div>
        ))} */}
      </div>
      <ToastContainer />
    </div>
  );
};

export default Mesa;
