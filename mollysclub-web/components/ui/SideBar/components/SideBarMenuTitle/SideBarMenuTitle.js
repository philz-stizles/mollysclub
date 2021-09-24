import React from 'react'

const SideBarMenuTitle = ({ title }) => {
  return (
    <div data-test="sidebar-menu-title" className="SideBarMenuTitle">
      <span data-test="menu-title">{title}</span>
      <style jsx>{`
        .SideBarMenuTitle {
          font-size: 13px;
          color: rgb(187, 186, 186);
          font-weight: bold;
        }

        // .SidebarMenuTitle {
        //   color: #8da2fb;
        //   /* font-size: .75rem; */
        //   /* font-size: 1rem; */
        //   font-size: 1.2rem;
        //   font-weight: 500;
        //   margin-bottom: 0.8rem;
        // }
      `}</style>
    </div>
  )
}

export default SideBarMenuTitle
