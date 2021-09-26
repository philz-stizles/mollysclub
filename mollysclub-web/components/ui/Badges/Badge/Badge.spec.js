import { shallow } from 'enzyme'
import Badge from './Badge'

describe('<Badge />', () => {
  let wrapper

  beforeEach(() => {
    wrapper = shallow(<Badge />)
  })

  it('should render without crashing', () => {
    expect(wrapper).toBeTruthy()
  })
})
