import React from 'react'
import FigureCard from '../../components/cards/FigureCard/FigureCard'
import Sidebar from '../../components/dashboard/Sidebar/Sidebar'
// import DashboardHeader from '../../components/dashboard/DashboardHeader/DashboardHeader'
import styles from './dashboard.module.scss'
import Image from 'next/image'

const AdminDashboard = () => {
  return (
    <>
      <input type="checkbox" id="nav-toggle" className={styles.navToggle} />

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

      <div className={styles.mainContent}>
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

        <main>
          <div className={styles.cards}>
            <FigureCard figure="54" text="Doctors" icon="las la-users" />

            <FigureCard figure="79" text="Patients" icon="las la-users" />

            <FigureCard figure="124" text="Hospitals" icon="las la-users" />

            <FigureCard figure="54" text="Doctors" icon="las la-users" />

            <FigureCard figure="79" text="Patients" icon="las la-users" />

            <FigureCard figure="124" text="Hospitals" icon="las la-users" />

            <FigureCard figure="79" text="Patients" icon="las la-users" />

            <FigureCard figure="124" text="Hospitals" icon="las la-users" />
          </div>
          
          <div className={styles.recentGrid}>
            <div className={styles.projects}>
              <div className={styles.card}>
                <div className={styles.card__header}>
                  <h4>Recent Projects</h4>
                  <button>See all <i className="las la-arrow-right" /></button>
                </div>

                <div className={styles.card__body}>
                  <div className={styles['table-responsive']}>
                    <table width="100%">
                      <thead>
                        <tr>
                          <td>Project Title</td>
                          <td>Department</td>
                          <td>Status</td>
                        </tr>
                      </thead>

                      <tbody>
                        <tr>
                          <td>UI/UX Design</td>
                          <td>UI Team</td>
                          <td><span className={[styles.status, styles.purple].join(' ')}></span> review</td>
                        </tr>
                        <tr>
                          <td>Web Development</td>
                          <td>Frontend</td>
                          <td><span className={[styles.status, styles.pink].join(' ')}></span> in progress</td>
                        </tr>
                        <tr>
                          <td>Ushop app</td>
                          <td>UMobile Team</td>
                          <td><span className={[styles.status, styles.orange].join(' ')}></span> pending</td>
                        </tr>
                        <tr>
                          <td>UI/UX Design</td>
                          <td>UI Team</td>
                          <td><span className={[styles.status, styles.purple].join(' ')}></span> review</td>
                        </tr>
                        <tr>
                          <td>Web Development</td>
                          <td>Frontend</td>
                          <td><span className={[styles.status, styles.pink].join(' ')}></span> in progress</td>
                        </tr>
                        <tr>
                          <td>Ushop app</td>
                          <td>UMobile Team</td>
                          <td><span className={[styles.status, styles.orange].join(' ')}></span> pending</td>
                        </tr>
                        <tr>
                          <td>UI/UX Design</td>
                          <td>UI Team</td>
                          <td><span className={[styles.status, styles.purple].join(' ')}></span> review</td>
                        </tr>
                        <tr>
                          <td>Web Development</td>
                          <td>Frontend</td>
                          <td><span className={[styles.status, styles.pink].join(' ')}></span> in progress</td>
                        </tr>
                        <tr>
                          <td>Ushop app</td>
                          <td>UMobile Team</td>
                          <td><span className={[styles.status, styles.orange].join(' ')}></span> pending</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>

            <div className={styles.customers}>
              <div className={styles.card}>
                <div className={styles.card__header}>
                  <h4>New Customers</h4>
                  <button>See all <i className="las la-arrow-right" /></button>
                </div>

                <div className={styles.card__body}>
                  <div className={styles.customer}>
                    <div className={styles.customer__info}>
                      <Image 
                        className={styles['customer__info--image']}
                        src="/images/default.jpg" 
                        alt="Default user image"
                        width={40}
                        height={40} />
                      <div className={styles['customer__info--details']}>
                        <h4>Lewis S. Cunningham</h4>
                        <small>CEO Excerpt</small>
                      </div>
                    </div>
                    <div className={styles.customer__contact}>
                      <i className="las la-user-circle" />
                      <i className="las la-comment" />
                      <i className="las la-phone" />
                    </div>
                  </div>
                  <div className={styles.customer}>
                    <div className={styles.customer__info}>
                      <Image 
                        className={styles['customer__info--image']}
                        src="/images/default.jpg" 
                        alt="Default user image"
                        width={40}
                        height={40} />
                      <div className={styles['customer__info--details']}>
                        <h4>Lewis S. Cunningham</h4>
                        <small>CEO Excerpt</small>
                      </div>
                    </div>
                    <div className={styles.customer__contact}>
                      <i className="las la-user-circle" />
                      <i className="las la-comment" />
                      <i className="las la-phone" />
                    </div>
                  </div>
                  <div className={styles.customer}>
                    <div className={styles.customer__info}>
                      <Image 
                        className={styles['customer__info--image']}
                        src="/images/default.jpg" 
                        alt="Default user image"
                        width={40}
                        height={40} />
                      <div className={styles['customer__info--details']}>
                        <h4>Lewis S. Cunningham</h4>
                        <small>CEO Excerpt</small>
                      </div>
                    </div>
                    <div className={styles.customer__contact}>
                      <i className="las la-user-circle" />
                      <i className="las la-comment" />
                      <i className="las la-phone" />
                    </div>
                  </div>
                  <div className={styles.customer}>
                    <div className={styles.customer__info}>
                      <Image 
                        className={styles['customer__info--image']}
                        src="/images/default.jpg" 
                        alt="Default user image"
                        width={40}
                        height={40} />
                      <div className={styles['customer__info--details']}>
                        <h4>Lewis S. Cunningham</h4>
                        <small>CEO Excerpt</small>
                      </div>
                    </div>
                    <div className={styles.customer__contact}>
                      <i className="las la-user-circle" />
                      <i className="las la-comment" />
                      <i className="las la-phone" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </main>
        <style jsx>{`
          #nav-toggle:checked + .sidebar{
            width: 70px;
          }
        `}</style>
      </div>
    </>
  )
}

export default AdminDashboard
