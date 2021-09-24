import React, { useEffect, useState } from 'react'
import SideBarMenu from './components/SideBarMenu/SideBarMenu'

import classes from './SideBar.module.scss'

const SideBar = ({ isOpen, blueprint, onClickMenuLink, mainContent }) => {
  console.log('Sidebar', mainContent)
  const [activeMenuItem, setActiveMenuItem] = useState('')

  useEffect(() => {
    setActiveMenuItem(mainContent)
    console.log('Sidebar useEffect', mainContent)
  }, [mainContent])

  const clickLinkHandler = id => {
    setActiveMenuItem(id)
    onClickMenuLink(id)
  }
  console.log('Sidebar', isOpen)
  // if (isLoading) return <div>Loading...</div>
  // if (error) return <div>{error.message}</div>

  const sidebarClass = isOpen
    ? [classes.SideBar]
    : [classes.sidebar, classes.isClosed]

  return (
    <div className={sidebarClass.join(' ')}>
      <div className={classes.SideBarWrapper}>
        {blueprint.map(menu => {
          return (
            <SideBarMenu
              key={menu.title}
              activeMenuItem={activeMenuItem}
              title={menu.title}
              menuItems={menu.menuItems}
              onClickLink={clickLinkHandler}
            />
          )
        })}
      </div>
    </div>
  )
}

export default SideBar
