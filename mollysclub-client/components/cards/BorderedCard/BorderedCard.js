import React from 'react'
import styles from './BorderedCard.module.scss'

const BorderedCard = ({icon, title, text}) => {
  return (
    <div className={styles.borderedCard}>
      <i className={[icon, styles.borderedCard__icon].join(' ')}></i>
      <h3 className={['u-margin-bxs', styles.borderedCard__title].join(' ')}>{title}</h3>
      <p className={styles.borderedCard__text}>{text}</p>
    </div>
  )
}

export default BorderedCard
