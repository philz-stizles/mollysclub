import React from 'react'
import BorderlessCard from '../../ui/Cards/BorderlessCard/BorderlessCard'
import styles from './Steps.module.scss'

const Steps = () => {
  return (
    <section className={styles.stepsSection}>
      <div className="row">
        <BorderlessCard
          icon="icon-basic-magnifier"
          title="Search specialist"
          text="Mollis ante, at porttitor nulla finibus acr et leo ac quam lobortis feugiat ac sed . Nunc condimentum justo lectus."
        />
        <BorderlessCard
          icon="icon-basic-magnifier"
          title="Check specialist profile"
          text="Ultricies mollis ante, at nulla finibus acr et leo ac quam lobortis feugiat ac sed . Nunc condimentum justo lectus."
        />
        <BorderlessCard
          icon="icon-basic-magnifier"
          title="Schedule appointment"
          text="Ante porttitor nulla finibus acr et leo ac quam lobortis feugiat ac sed . Nunc condimentum justo lectus."
        />
        <BorderlessCard
          icon="icon-basic-magnifier"
          title="Get perscriptions"
          text="Porttitor nulla finibus acr et leo ac quam lobortis feugiat ac sed . Nunc condimentum justo lectus."
        />
      </div>
    </section>
  )
}

export default Steps
