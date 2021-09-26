import React from 'react'
import StatCard from '../../ui/Cards/StatCard/StatCard'
import styles from './Stats.module.scss'

const Stats = () => {
  return (
    <div className={styles.stats}>
      <div className="row" style={{ justifyContent: 'center' }}>
        <StatCard
          color="#FFF7EA"
          figure="850"
          title="Verified Physicians"
          text="Highly Verified"
        />
        <StatCard
          color="#ECF9FF"
          figure="1000+"
          title="Happy Customers"
          text="Positive Feedback"
        />
        <StatCard
          color="#FEF0F0"
          figure="98.4%"
          title="Positive Feedback"
          text="Highly Verified"
        />
      </div>
    </div>
  )
}

export default Stats
