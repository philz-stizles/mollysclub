import React from 'react'
import SimpleArticle from '../../articles/SimpleArticle'
import styles from './Consultation.module.scss'

const Consultation = () => {
  return (
    <div className={styles.consultation}>
      <div className={['row'].join(' ')}>
        <div className={styles.consultation__article}>
          <SimpleArticle 
            title="<h2>Consult a doctore anytime, <br /> anywhere and search</h2>"
            subTitle="find doctors"
            btnText="Search specialists"
            text="Access to Medical Personnel for remote consultation: Have multiple chats with Medical Personnel over thirty (30) days. Get regular information on your current health status."
            list={[]}/>
        </div>
        <div className={styles.consultation__image}>
        </div>
      </div>
    </div>
  )
}

export default Consultation
