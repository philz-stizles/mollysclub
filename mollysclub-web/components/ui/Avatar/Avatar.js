import React from 'react'
import Image from 'next/image'
import classes from './Avatar.module.scss'

const Avatar = ({ src, alt }) => {
  return (
    <div className={classes.Avatar}>
      <Image width={50} height={50} src={src} objectFit="cover" alt={alt} />
    </div>
  )
}

export default Avatar
