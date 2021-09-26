import React from 'react'
import classes from './Badge.module.scss'

const Badge = ({ label }) => {
  return <button className={classes.Badge}>{label}</button>
}

export default Badge
