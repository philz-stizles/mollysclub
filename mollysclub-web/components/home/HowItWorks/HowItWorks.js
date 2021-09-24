import React from 'react'
import BorderedCard from '../../cards/BorderedCard/BorderedCard'
import styles from './HowItWorks.module.scss'

const HowItWorks = () => {
  return (
    <section className={styles.howItWorks}>
        <div className="row">
          <BorderedCard 
            icon="icon-basic-world" 
            title="Explore the world"
            text="Erat nec rutrum rhoncus sodales, quis mattis ante nec massa eu rhoncus arcu."/>
          
          <BorderedCard
            icon="icon-basic-compass"
            title="Meet nature"
            text="Sodales, quis mattis sapien ante ne. Ut rhoncus sollicitudin rhoncus arcupt."/>
          
          <BorderedCard
            icon="icon-basic-map"
            title="Find your way"
            text="Quis mattis sapien ante rhoncus nec massa. Nam ut sollicitudin lacus, eu." />
          
          <BorderedCard
            icon="icon-basic-heart"
            title="Healthier life"
            text="Mattis sapien ante nec massa. Nam ut sollicitudin lacus, eu rhoncus arcu." />
        </div>
      </section>
  )
}

export default HowItWorks
