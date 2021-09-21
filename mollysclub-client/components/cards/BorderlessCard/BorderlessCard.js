import React from 'react'
import styles from './BorderlessCard.module.scss'

const BorderlessCard = ({icon, title, text}) => {
  return (
    <div className={styles.borderlessCard}>
      <i className={[icon, styles.borderlessCard__icon].join(' ')}></i>
      <h3 className={styles.borderlessCard__title}>{title}</h3>
      <p className={styles.borderlessCard__text}>{text}</p>
    </div>
  )
}

export default BorderlessCard
