import React, { useEffect, useState } from 'react';
import { getUserDetails } from '../../../services/auth'
import { getAllMesas } from '../../../services/mesa'
import { addReserva } from '../../../services/reserva';

const Mesa = () => {
  const [roles, setUserRole] = useState([{}])
  const [mesaList, setMesaList] = useState([])
  const [refresh, setRefresh] = useState(false)
  const [openModal, setOpenModal] = useState(false)
  const [showProductFeedback, setProductFeedback] = React.useState({ show: false, status: false, infoText: '' })

  useEffect(() => {
    getUserDetails({ setUserRole })
    getAllMesas({ setMesaList })
  }, [refresh])

  const handleOpenModal = () => setOpenModal(true)
  const closeProductFeedback = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setProductFeedback({ show: false });
  };

  const addMesa = (fechaToAdd, mesaToAdd) => {
    addReserva({ fechaToAdd, mesaToAdd })
    //console.log(mesaToAdd, fechaToAdd)
  }

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
            <a href={'//localhost:3000/store/detail/' + item.id + '/' + item.category}>
              
              <img
                src={item.tipo_mesa.foto}
                alt={item.tipo_mesa.descripcion}
                className='w-full h-[200px] object-cover rounded-t-lg '
              />

            </a>
            <div className='flex justify-between px-2 py-4'>
              <p className='font-bold'>Mesa N°{item.id_mesa}</p>
              <p>
              <span className='bg-amber-600 text-white p-2 mr-2 rounded-full'>
                  {item.tipo_mesa.capacidad} Personas
                </span>
                <span className='bg-amber-600 text-white p-2 mr-2 rounded-full'>
                  {item.estado}
                </span>
                <button className='bg-amber-600 hover:bg-amber-900 transition-colors text-white p-1.5 rounded-full' onClick={() => {
              addMesa("2020-01-01", item)
            }}>
                    Reservar
                </button>
              </p>
            </div>
            
          </div>
        ))}
      </div>
    </div>
  );
};

export default Mesa;
