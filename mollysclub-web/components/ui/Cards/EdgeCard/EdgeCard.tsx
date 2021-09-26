import React from 'react'
import classes from './EdgeCard.module.scss'

const EdgeCard = ({ title, figure, subFigure, icon, meta }) => {
  return (
    <div className={classes.EdgeCard}>
      <span className={classes.EdgeCardTitle}>{title}</span>
      <div className={classes.EdgeCardMoneyContainer}>
        <span className={classes.EdgeCardMoney}>{figure}</span>
        <span className={classes.EdgeCardMoneyRate}>
          {subFigure}{' '}
          <i className={[classes.EdgeCardIcon, 'negative', icon].join(' ')} />
        </span>
      </div>
      <span className={classes.EdgeCardSub}>{meta}</span>
    </div>
  )
}

export default EdgeCard
