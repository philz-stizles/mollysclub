import classes from './StatsInfo.module.scss'
import EdgeCard from '../../ui/Cards/EdgeCard/EdgeCard'

const StatsInfo = () => {
  return (
    <div className={classes.StatsInfo}>
      <EdgeCard
        title="Doctors"
        figure="$2,415"
        subFigure="-11.4"
        icon="las la-arrow-up"
        meta="Compared to last month"
      />
      <EdgeCard
        title="Patients"
        figure="$4,415"
        subFigure="-1.4"
        icon="las la-arrow-down"
        meta="Compared to last month"
      />
      <EdgeCard
        title="Patients"
        figure="$2,225"
        subFigure="+2.4"
        icon="las la-arrow-down"
        meta="Compared to last month"
      />
      <EdgeCard
        title="Patients"
        figure="$2,225"
        subFigure="+2.4"
        icon="las la-arrow-down"
        meta="Compared to last month"
      />
    </div>
  )
}

export default StatsInfo
