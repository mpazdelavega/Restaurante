import { getApiUrl } from './apiConfig'
import axios from 'axios'

export const addReserva = ({ fechaToAdd, mesaToAdd, horaToAdd }) => {
    const addUrl = getApiUrl('reserva')
    const userDetailUrl = getApiUrl('auth/details')
    axios.get(userDetailUrl, { withCredentials: true }).then(userDetails => {
        let reservaObject = {
            fecha: fechaToAdd,
            hora: horaToAdd,
            estado_reserva: "No Cancelado",
            client: userDetails.data,
            mesa: mesaToAdd
        }
        console.log(reservaObject)
        axios.post(addUrl, reservaObject, { withCredentials: true })
    })
}
export const deleteReservaItem = ({ itemId }) => {
    const deleteUrl = getApiUrl(`reserva/clean/${itemId}`)
    return axios.delete(deleteUrl, { withCredentials: true })
}
export const getReservaList = ({ setListaReserva }) => {
    const listUrl = getApiUrl("reserva")
    axios.get(listUrl, { withCredentials: true }).then(response => {
        setListaReserva(response.data)
    })
}
export const generateSale = () => {
    const saleUrl = getApiUrl(`sale/create`)
    return axios.post(saleUrl, null, { withCredentials: true })
}
export const getSaleList = ({ setSalesList }) => {
    const listUrl = getApiUrl("sale/client")
    axios.get(listUrl, { withCredentials: true }).then(response => {
        setSalesList(response.data)
    })
}

export const updateReserva = ({ reserva }) => {
    console.log(reserva)
    const reservaUpdateUrl = getApiUrl("reserva/update")
    axios.put(reservaUpdateUrl, reserva, { withCredentials: true })  
}