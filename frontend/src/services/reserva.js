import { getApiUrl } from './apiConfig'
import axios from 'axios'

export const addReserva = ({ fechaToAdd, mesaToAdd }) => {
    const addUrl = getApiUrl('reserva')
    const userDetailUrl = getApiUrl('auth/details')
    axios.get(userDetailUrl, { withCredentials: true }).then(userDetails => {
        let reservaObject = {
            fecha: fechaToAdd,
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
export const getReservaList = ({ setProductList }) => {
    const listUrl = getApiUrl("reserva")
    axios.get(listUrl, { withCredentials: true }).then(response => {
        setProductList(response.data)
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