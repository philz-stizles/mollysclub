import React from 'react'
import styles from './Sidebar.module.scss'

const Sidebar = () => {
  return (
    <div className={styles.sidebar}>
      <div className={styles.sidebar__brand}>
        <h2><i className="las la-stethoscope" /> <span>Mollys Club</span></h2>
      </div>

      <div className={styles.sidebar__menu}>
        <ul>
          <li><a className={styles.active} href="#"><i className="las la-h-square" /> <span>Dashboard</span></a></li>
          <li><a className="" href="#"><i className="las la-hospital" /> <span>Hospitals</span></a></li>
          <li><a className="" href="#"><i className="las la-user-md" /> <span>Patients</span></a></li>
          <li><a className="" href="#"><i className="las la-stethoscope" /> <span>Doctors</span></a></li>
          <li><a className="" href="#"><i className="las la-briefcase-medical" /> <span>Pharmacies</span></a></li>
          <li><a className="" href="#"><i className="las la-stethoscope" /> <span>Gymns</span></a></li>
          <li><a className="" href="#"><i className="las la-cog" /> <span>Settings</span></a></li>
        </ul>
      </div>
    </div>
  )
}

export default Sidebar
