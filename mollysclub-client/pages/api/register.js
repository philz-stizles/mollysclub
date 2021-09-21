// Next.js API route support: https://nextjs.org/docs/api-routes/introduction
// Any code in any file in the api folder will never be exposed to the public, 
// or be exposed to the client-side code bundle
import nextConnect from 'next-connect'
import middleware from '../../middleware/database'

const handler = nextConnect()

handler.use(middleware)

handler.post(async (req, res) => {
  const { name, phone, email } = req.body
  console.log(name)
  res.json({message: 'Registration successful'})
})

export default handler