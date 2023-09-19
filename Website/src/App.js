import {AboutUs} from "./AboutUs";
import {Home} from "./Home";
import {Documents} from "./Documents";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Logo from "./Assets/Bilkent_University_Crest.svg.png";
import Nav from "react-bootstrap/Nav";
import 'bootstrap/dist/css/bootstrap.min.css';
import {useRef} from "react";
import {TheTeam} from "./TheTeam";
import Background from "./Assets/output-onlinepngtools.png"

function App() {
    const ref1 = useRef(null);
    const ref2 = useRef(null);
    const ref3 = useRef(null);
    const ref4 = useRef(null);

    const handleClick1 = () => {
        window.scrollTo(
            {
                top: ref1.current.offsetTop,
                behavior: 'smooth'
            });
    };
    const handleClick2 = () => {
        window.scrollTo(
            {
                top: ref2.current.offsetTop,
                behavior: 'smooth'
            });
        console.log("test")
    };
    const handleClick3 = () => {
        window.scrollTo(
            {
                top: ref3.current.offsetTop,
                behavior: 'smooth'
            });
        console.log("test")
    };
    const handleClick4 = () => {
        window.scrollTo(
            {
                top: ref4.current.offsetTop,
                behavior: 'smooth'
            });
        console.log("test")
    };
  return (
    <div style={{
        backgroundImage: `url(${Background}`,
    }}>
        <Navbar bg="primary" data-bs-theme="dark" className="justify-content-start bg-body-tertiary">
              <Container className='justify-content-start'>
                  <Navbar.Brand href='#Home' onClick={handleClick1} >
                      <img width="50"
                           height="50"
                           className="d-inline-block align-top"
                           src={Logo}
                           alt="HomeLogo"
                      />
                  </Navbar.Brand>
                  <Nav className='me-auto'>
                      <Nav.Link onClick={handleClick2} >About US</Nav.Link>
                      <Nav.Link onClick={handleClick3}>The Team</Nav.Link>
                      <Nav.Link  onClick={handleClick4}>Documents</Nav.Link>
                      <Nav.Link href="https://github.com/cmglmsr/ORTACI-GAZETE">GitHub</Nav.Link>
                  </Nav>
              </Container>

          </Navbar>
        <div ref={ref1} style={{height: '1080px'}}>
            <Home/>
        </div>
        <div ref={ref2} style={{height: '1080px'}}>
        <AboutUs />
      </div>
        <div ref={ref3} >
        <TheTeam />
      </div>
        <div ref={ref4} style={{height: '540px'}}>
        <Documents />
      </div>
    </div>
  );
}

export default App;
