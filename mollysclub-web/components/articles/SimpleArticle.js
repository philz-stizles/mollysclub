import React, { Fragment } from 'react'
import HTMLRenderer from 'react-html-renderer'
import Button from '../ui/Buttons/Button/Button'
import styles from './SimpleArticle.module.scss'

const SimpleArticle = ({ title, subTitle, text, btnText, list }) => {
  return (
    <div className={styles.simpleArticle}>
      <h6 className={styles.simpleArticle__subTitle}>{subTitle}</h6>
      <HTMLRenderer
        html={title}
        components={{
          h2: props => (
            <h2
              className={['u-margin-bxs', styles.simpleArticle__title].join(
                ' '
              )}
            >
              {props.children}
            </h2>
          ),
        }}
      />
      <p className={['u-margin-bs', styles.simpleArticle__text].join(' ')}>
        {text}
      </p>
      {list && (
        <ul>
          {list.map(item => {
            return <li>{item}</li>
          })}
        </ul>
      )}
      <Button>{btnText} &rarr;</Button>
    </div>
  )
}

export default SimpleArticle
