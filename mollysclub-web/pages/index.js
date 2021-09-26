import Consultation from '../components/home/Consultation/Consultation'
import Stats from '../components/home/Stats/Stats'
import Steps from '../components/home/Steps/Steps'
import Layout from '../components/layouts/MainLayout/MainLayout'

export default function Home() {
  return (
    <Layout>
      <Steps />
      <Consultation />
      <Stats />
    </Layout>
  )
}
