import React from 'react'
import Button from '../../ui/Buttons/Button/Button'
import styles from './Navbar.module.scss'

const Navbar = () => {
  return (
    <div className={styles.navbar}>
      <div className="row">
        <div className={styles.navbar__logo}>
          <img
            src="https://mollysclubng.com/wp-content/themes/getleads/assets/images/logo/logo-white.png"
            alt="Mollys Club Logo"
          />
        </div>

        <ul className={styles.nav}>
          <li className={styles.nav__item}>
            <a className={styles.nav__link} href="/about">
              About us
            </a>
          </li>
          <li className={styles.nav__item}>
            <a className={styles.nav__link} href="/find-a-doctor">
              Find a Doctor
            </a>
          </li>
          <li className={styles.nav__item}>
            <a className={styles.nav__link} href="/services">
              Our Services
            </a>
          </li>
          <li className={styles.nav__item}>
            <a className={styles.nav__link} href="/how-it-works">
              How it Works
            </a>
          </li>
          <li className={styles.nav__item}>
            <a className={styles.nav__link} href="/pricing">
              Pricing
            </a>
          </li>
          <li className={styles.nav__item}>
            <Button>Join now</Button>
          </li>
        </ul>
      </div>
    </div>
  )
}

export default Navbar
