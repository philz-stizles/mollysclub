import React from 'react'
import classes from './IconBadge.module.scss'

const IconBadge = ({ icon, badge }) => {
  return (
    <div className={classes.IconBadge}>
      <i className={['las', `la-${icon}`, 'la-2x'].join(' ')} />
      {badge && <span className={classes.Badge}>{badge}</span>}
    </div>
  )
}

export default IconBadge
