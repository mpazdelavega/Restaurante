import React, { useEffect, useState } from 'react';
import ProductCard from './productCard'
import { getUserDetails } from '../../../services/auth'
import ProductForm from '../../client/components/productForm'
import { getAllProducts, getBestProducts } from '../../../services/product'
import { addToCart } from '../../../services/shoppingCart'

const Food = () => {
  const [roles, setUserRole] = useState([{}])
  const [productList, setProductList] = useState([])
  const [bestProductList, setBestProductList] = useState([])
  const [product, setProduct] = useState({ name: "", price: 0, description: "", category: "", image: "" })
  const [refresh, setRefresh] = useState(false)
  const [openModal, setOpenModal] = useState(false)
  const [showProductFeedback, setProductFeedback] = React.useState({ show: false, status: false, infoText: '' })

  useEffect(() => {
    getUserDetails({ setUserRole })
    getAllProducts({ setProductList })
    getBestProducts({ setBestProductList })
  }, [refresh])

  const handleOpenModal = () => setOpenModal(true)
  const closeProductFeedback = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setProductFeedback({ show: false });
  };
  const addProduct = (productToAdd, amountToAdd) => {
    addToCart({ amountToAdd, productToAdd })
  }


  return (
    <div className='max-w-[1640px] m-auto px-4 py-12'>
      <h1 className='text-amber-600 font-bold text-4xl text-center'>
        Mejores productos
      </h1>
      {/* Display foods */}
      <div className='grid grid-cols-2 lg:grid-cols-4 gap-6 pt-4'>
        {bestProductList.map((productItem) => (
          <div
            key={productItem.id}
            className='border shadow-lg rounded-lg hover:scale-105 duration-300'
          >
            <a href={'//localhost:3000/store/detail/' + productItem.id + '/' + productItem.category}>
              <img
                src={productItem.image}
                alt={productItem.name}
                className='w-full h-[200px] object-cover rounded-t-lg'
              />
            </a>
            <div className='flex justify-between px-2 py-4'>
              <p className='font-bold'>{productItem.name}</p>
              <p>
                <span className='bg-amber-600 text-white p-2 mr-2 rounded-full'>
                  ${productItem.price}
                </span>
                <button onClick={() => {
              addProduct(productItem, 1)
            }} className='bg-amber-600 hover:bg-amber-900 transition-colors text-white p-1.5 rounded-full'>
                    Agregar
                </button>
              </p>
            </div>
            
          </div>
        ))}
      </div>
      <h1 className='text-amber-600 font-bold text-4xl text-center mt-10'>
        Menu
      </h1>
      {/* Display foods */}
      <div className='grid grid-cols-2 lg:grid-cols-4 gap-6 pt-4'>
        {productList.map((productItem) => (
          <div
            key={productItem.id}
            className='border shadow-lg rounded-lg hover:scale-105 duration-300'
          >
            <a href={'//localhost:3000/store/detail/' + productItem.id + '/' + productItem.category}>
              <img
                src={productItem.image}
                alt={productItem.name}
                className='w-full h-[200px] object-cover rounded-t-lg'
              />
            </a>
            <div className='flex justify-between px-2 py-4'>
              <p className='font-bold'>{productItem.name}</p>
              <p>
                <span className='bg-amber-600 text-white p-2 mr-2 rounded-full'>
                  ${productItem.price}
                </span>
                <button onClick={() => {
              addProduct(productItem, 1)
            }} className='bg-amber-600 hover:bg-amber-900 transition-colors text-white p-1.5 rounded-full'>
                    Agregar
                </button>
              </p>
            </div>
            
          </div>
        ))}
      </div>
    </div>
  );
};

export default Food;
