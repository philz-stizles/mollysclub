import Link from 'next/link'
import classes from './SideBar.module.scss'

const SideBar = () => {
  return (
    <div className={classes.sidebar}>
      <div className={classes.sidebarWrapper}>
        <div className={classes.sidebarMenu}>
          <h3 className={classes.sidebarTitle}>Dashboard</h3>
          <ul className={classes.sidebarList}>
            <Link href="/" className="link">
              <li
                className={[classes.sidebarListItem, classes.active].join(' ')}
              >
                <i
                  className={[classes.sidebarIcon, 'las la-home'].join(' ')}
                ></i>
                Home
              </li>
            </Link>
            <li className={classes.sidebarListItem}>
              <i className="las la-chart-area"></i>
              Analytics
            </li>
            <li className={classes.sidebarListItem}>
              <i className="las la-chart-line"></i>
              Sales
            </li>
          </ul>
        </div>
        <div className={classes.sidebarMenu}>
          <h3 className={classes.sidebarTitle}>Quick Menu</h3>
          <ul className={classes.sidebarList}>
            <Link href="/users" className="link">
              <li className={classes.sidebarListItem}>
                <i className="las la-users"></i>
                Users
              </li>
            </Link>
            <Link href="/products" className="link">
              <li className={classes.sidebarListItem}>
                <i className="las la-shrefre"></i>
                Products
              </li>
            </Link>
            <li className={classes.sidebarListItem}>
              <i className="las la-wallet"></i>
              Transactions
            </li>
            <li className={classes.sidebarListItem}>
              <i className="las la-chart-bar"></i>
              Reports
            </li>
          </ul>
        </div>
        <div className={classes.sidebarMenu}>
          <h3 className={classes.sidebarTitle}>Notifications</h3>
          <ul className={classes.sidebarList}>
            <li className={classes.sidebarListItem}>
              <i className="las la-envelope"></i>
              Mail
            </li>
            <li className={classes.sidebarListItem}>
              <i className="las la-comments"></i>
              Feedback
            </li>
            <li className={classes.sidebarListItem}>
              <i className="lab la-rocketchat"></i>
              Messages
            </li>
          </ul>
        </div>
        <div className={classes.sidebarMenu}>
          <h3 className={classes.sidebarTitle}>Staff</h3>
          <ul className={classes.sidebarList}>
            <li className={classes.sidebarListItem}>
              <i className="lab la-rocketchat"></i>
              Manage
            </li>
            <li className={classes.sidebarListItem}>
              <i className="lab la-rocketchat"></i>
              Analytics
            </li>
            <li className={classes.sidebarListItem}>
              <i className="lab la-rocketchat"></i>
              Reports
            </li>
          </ul>
        </div>
      </div>
    </div>
  )
}

export default SideBar
