import React from 'react'
import styles from './FlipCard.module.scss'

const FlipCard = ({}) => {
  return (
    <div className={styles.card}>
      <div className={[styles.card__side, styles.card__side__front].join(' ')}>
        <div className={[styles.card__picture, styles.card__picture-1].join(' ')}></div>
        <h4 className={styles.card__heading}>
          <span className={[styles.card__heading__span, styles.card__heading__span-1].join(' ')}>The Sea Explorer</span>
        </h4>
        <div className={styles.card__details}>
          <ul>
            <li>3 day tours</li>
            <li>Up to 30 people</li>
            <li>2 tour guides</li>
            <li>Sleep in cozy hotels</li>
            <li>Difficulty: easy</li>
          </ul>
        </div>
      </div>
      <div className="card__side card__side-back card__side-back-1">
        <div className="card__cta">
          <div className="card__price-box">
            <p className="card__price-only">Only</p>
            <p className="card__price-value">$297</p>
          </div>
          <a href="#popup" className="btn btn--white">Book now!</a>
        </div>
      </div>
    </div>
  )
}

export default FlipCard
