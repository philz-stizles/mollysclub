import React from 'react'
import styles from './statCard.module.scss'

const StatCard = ({color, figure, title, text}) => {
  return (
    <div style={{
      backgroundColor: color
    }} className={styles.statCard}>
      <h2 className={['u-margin-bxxs', styles.statCard__title].join(' ')}>{figure}</h2>
      <h5 className={styles.statCard__title}>{title}</h5>
      <p className={styles.statCard__text}>{text}</p>
    </div>
  )
}

export default StatCard
