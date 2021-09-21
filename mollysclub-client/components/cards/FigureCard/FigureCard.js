import React from 'react'
import styles from './FigureCard.module.scss'

const FigureCard = ({figure, text, icon}) => {
  return (
    <div className={styles.figureCard}>
      <div>
        <h1>{figure}</h1>
        <span>{text}</span>
      </div>

      <div>
        <i className={icon} />
      </div>
    </div>
  )
}

export default FigureCard
