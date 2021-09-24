import { shallow } from 'enzyme'
import IconBadge from './IconBadge'

describe('<IconBadge />', () => {
  let wrapper

  beforeEach(() => {
    wrapper = shallow(<IconBadge />)
  })

  it('should render without crashing', () => {
    expect(wrapper).toBeTruthy()
  })
})
