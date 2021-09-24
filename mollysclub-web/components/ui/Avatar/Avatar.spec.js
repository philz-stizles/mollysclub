import { shallow } from 'enzyme'
import Avatar from './Avatar'

describe('<Avatar />', () => {
  let wrapper

  beforeEach(() => {
    wrapper = shallow(<Avatar />)
  })

  it('should render without crashing', () => {
    expect(wrapper).toBeTruthy()
  })
})
