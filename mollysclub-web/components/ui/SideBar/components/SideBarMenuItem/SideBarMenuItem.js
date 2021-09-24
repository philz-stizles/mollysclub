import React from 'react'
import Link from 'next/link'
import { useRouter } from 'next/router'

const SideBarMenuItem = ({ name, icon, href, isActive }) => {
  const router = useRouter()

  const style = {
    backgroundColor: router.asPath === href ? 'rgb(240, 240, 255)' : '',
  }

  const sidebarClasses = isActive
    ? ['SideBarMenuItem', 'active']
    : ['SideBarMenuItem']
  return (
    <li
      data-test="list-item"
      className={sidebarClasses.join(' ')}
      aria-hidden="true"
      style={style}
    >
      <Link href={href}>
        <a>
          <i data-test="list-item-icon" className={icon} />
          <span data-test="list-item-text"> {name}</span>
        </a>
      </Link>
      <style jsx>{`
        .SideBarMenuItem {
          padding: 5px;
          cursor: pointer;
          display: flex;
          align-items: center;
          border-radius: 10px;
        }

        .SideBarMenuItem i {
          margin-right: 5px;
          font-size: 20px !important;
        }

        // .SideBarMenuItem {
        //   margin-bottom: 0.9rem;
        //   color: #efefef;
        //   font-size: 1.4rem;
        //   display: flex;
        //   align-items: center;
        //   cursor: pointer;
        //   border-left-width: 3px;
        //   border-left-style: solid;
        //   border-left-color: transparent;
        //   transition: all 0.3s;
        // }

        // .SideBarMenuItem.active {
        //   padding-left: 0.5rem;
        //   border-left-color: #8da2fb;
        // }

        // .SideBarMenuItem.active i {
        //   color: #8da2fb;
        // }

        // .SideBarMenuItem i {
        //   font-size: 2.4rem;
        //   display: inline-block;
        //   margin-right: 1rem;
        // }
      `}</style>
    </li>
  )
}

export default SideBarMenuItem
