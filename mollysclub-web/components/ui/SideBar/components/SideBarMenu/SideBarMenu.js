import React from 'react'
import SideBarMenuItem from '../SideBarMenuItem/SideBarMenuItem'
import SideBarMenuTitle from '../SideBarMenuTitle/SideBarMenuTitle'

const SideBarMenu = ({ title, menuItems, onClickLink, activeMenuItem }) => {
  return (
    <div data-test="sidebar-menu" className="SideBarMenu">
      {title && <SideBarMenuTitle title={title} />}

      <ul data-test="sidebar-menu-ul">
        {menuItems.map(item => (
          <SideBarMenuItem
            key={item.name}
            {...item}
            onClickLink={() => onClickLink(item.id)}
            isActive={item.id === activeMenuItem}
          />
        ))}
      </ul>
      <style jsx>
        {`
          .SideBarMenu {
            margin-bottom: 10px;
          }

          .SideBarMenu ul {
            list-style: none;
            padding: 5px;
          }

          // .SideBarMenu {
          //   margin-top: 3rem;
          // }

          // .SideBarMenu ul {
          //   margin-bottom: 1.5rem;
          // }
        `}
      </style>
    </div>
  )
}

export default SideBarMenu
