import { getApiUrl } from './apiConfig'
import axios from 'axios'

export const getAllMesas = ({ setMesaList }) => {
    const mesaUrl = getApiUrl("mesa/getAll")
    axios.get(mesaUrl, { withCredentials: true }).then((response) => {
        setMesaList(response.data)
    })
}