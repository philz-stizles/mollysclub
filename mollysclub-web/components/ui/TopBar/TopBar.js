import React from 'react'
import Avatar from '../Avatar/Avatar'
import IconBadge from '../Badges/IconBadge/IconBadge'
import classes from './TopBar.module.scss'

const TopBar = () => {
  return (
    <div className={classes.topbar}>
      <div className={classes.topbarWrapper}>
        <div className={classes.topLeft}>
          <span className={classes.logo}>
            <i
              className="las la-stethoscope la-2x"
              style={{ fontSize: '1.4em' }}
            />
          </span>
        </div>
        <div className={classes.topRight}>
          <IconBadge icon="bell" badge={2} />
          <IconBadge icon="globe" badge={2} />
          <IconBadge icon="cog" />
          <Avatar src="/images/user.jpg" />
        </div>
      </div>
    </div>
  )
}

export default TopBar
