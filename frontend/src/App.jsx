import { BrowserRouter as Router, Routes, Route } from "react-router-dom"
import Homepage from "./components/homepage/Homepage";
import Authentication from "./components/authentication/Authentication";

export default function App() {
  return <>
  <Router>
    <Routes>
      <Route path="/" element={true ? <Homepage/>: <Authentication/>}></Route>
    </Routes>
  </Router>
  </>
}
