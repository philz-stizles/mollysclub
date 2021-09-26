import React from 'react'
import DashboardLayout from '../../../components/layouts/DashboardLayout/DashboardLayout'
import StatsInfo from '../../../components/analytics/StatsInfo/StatsInfo'
import LineChart from '../../../components/charts/LineChart/LineChart'
import PieChart from '../../../components/charts/PieChart/PieChart'
import { userData } from '../../../data/dummyData'

const AdminDashboard = () => {
  return (
    <DashboardLayout>
      <StatsInfo />
      <LineChart
        data={userData}
        title="User Analytics"
        grid
        dataKey="Active User"
      />
      <PieChart onPieEnter={() => {}} />
    </DashboardLayout>
  )
}

export default AdminDashboard
