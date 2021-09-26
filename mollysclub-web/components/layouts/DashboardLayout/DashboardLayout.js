// External packages.
import React, { useState } from 'react'
// Custom components.
import TopBar from '../../ui/TopBar/TopBar'
import SideBar from '../../ui/SideBar/SideBar'

const DashboardLayout = ({ children }) => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(true)
  const SidebarBlueprint = [
    {
      title: 'Tenants',
      menuItems: [
        {
          href: '/admin/dashboard',
          name: 'Analytics',
          icon: 'las la-tachometer-alt',
        },
        {
          href: '/admin/dashboard/doctors',
          name: 'Doctors',
          icon: 'las la-project-diagram',
        },
        {
          href: '/admin/dashboard/patients',
          name: 'Patients',
          icon: 'las la-object-group',
        },
        {
          href: '/admin/dashboard/pharmacies',
          name: 'Pharmacies',
          icon: 'las la-blog',
        },
        {
          href: '/admin/dashboard/test-centers',
          name: 'Test centers',
          icon: 'las la-briefcase',
        },
        {
          href: '/admin/dashboard/gymns',
          name: 'Gymns',
          icon: 'las la-briefcase',
        },
      ],
    },
    {
      title: 'Audit',
      menuItems: [
        {
          href: '/admin/dashboard/transactions',
          name: 'Transactions',
          icon: 'las la-user-cog',
        },
        {
          href: '/admin/dashboard/notifications',
          name: 'Notifications',
          icon: 'las la-comment',
        },
        {
          href: '/admin/dashboard/tasks',
          name: 'Tasks',
          icon: 'las la-tasks',
        },
      ],
    },
    {
      title: 'Settings',
      menuItems: [
        {
          href: '/admin/dashboard/roles',
          name: 'Roles',
          icon: 'las la-user-cog',
        },
        {
          href: '/admin/dashboard/audit',
          name: 'Audit',
          icon: 'las la-comment',
        },
        {
          href: '/admin/dashboard/profile',
          name: 'Profile',
          icon: 'las la-tasks',
        },
      ],
    },
  ]

  return (
    <>
      <TopBar />
      <div className="container">
        <SideBar
          isOpen={isSidebarOpen}
          blueprint={SidebarBlueprint}
          onClickMenuLink={() => {}}
        />
        <main>{children}</main>
        <style jsx>
          {`
            main {
              padding: 2rem 2rem;
              flex: 4 1;
              // background-color: #f5f8fa;
            }
          `}
        </style>
      </div>
    </>
  )
}

export default DashboardLayout
