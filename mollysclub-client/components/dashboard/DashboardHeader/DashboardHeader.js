import React from 'react'
import styles from './DashboardHeader.module.scss'
import Image from 'next/image'

const DashboardHeader = () => {
  return (
    <header className={styles.header}>
      <h2><label htmlFor="nav-toggle"><i className="las la-bars" /></label> Dashboard</h2>

      <div className={styles.searchWrapper}>
        <i className="las la-search" />
        <input type="search" placeholder="Search here" />
      </div>

      <div className={styles.userWrapper}>
        <Image
          src="/images/default.jpg"
          alt="Default user image"
          width={40}
          height={40}
        />
        <div className={styles.userWrapper__details}>
          <h4>John Doe</h4>
          <small>Super admin</small>
        </div>
      </div>
    </header>
  )
}

export default DashboardHeader
