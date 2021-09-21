import React from 'react'
import FlipCard from '../../cards/FlipCard/FlipCard'

const Membership = () => {
  return (
    <section class="section-tours" id="section-tours">
      <div class="u-center-text u-margin-bottom-big">
        <h2 class="heading-secondary">Most popular tours</h2>
      </div>
      <div class="row">
          <FlipCard />
        
          <div class="card">
            <div class="card__side card__side--front">
              <div class="card__picture card__picture--2"></div>
              <h4 class="card__heading">
                <span class="card__heading-span card__heading-span--2">The Forest Hiker</span>
              </h4>
              <div class="card__details">
                <ul>
                  <li>7 day tours</li>
                  <li>Up to 40 people</li>
                  <li>6 tour guides</li>
                  <li>Sleep in provided tents</li>
                  <li>Difficulty: medium</li>
                </ul>
              </div>
            </div>
            <div class="card__side card__side--back card__side--back-2">
              <div class="card__cta">
                <div class="card__price-box">
                  <p class="card__price-only">Only</p>
                  <p class="card__price-value">$497</p>
                </div>
                <a href="#popup" class="btn btn--white">Book now!</a>
              </div>
            </div>
        </div>
  
        
          <div class="card">
            <div class="card__side card__side--front">
              <div class="card__picture card__picture--3"></div>
              <h4 class="card__heading">
                <span class="card__heading-span card__heading-span--3">The Snow Adventurer</span>
              </h4>
              <div class="card__details">
                <ul>
                  <li>5 day tours</li>
                  <li>Up to 15 people</li>
                  <li>3 tour guides</li>
                  <li>Sleep in provided tents</li>
                  <li>Difficulty: hard</li>
                </ul>
              </div>
            </div>
            <div class="card__side card__side--back card__side--back-3">
              <div class="card__cta">
                <div class="card__price-box">
                  <p class="card__price-only">Only</p>
                  <p class="card__price-value">$897</p>
                </div>
                <a href="#popup" class="btn btn--white">Book now!</a>
              </div>
            </div>
          </div>
        </div>

      <div class="u-center-text u-margin-top-huge">
        <a href="#" class="btn btn--green">Discover all tours</a>
      </div>
    </section>
  )
}

export default Membership
