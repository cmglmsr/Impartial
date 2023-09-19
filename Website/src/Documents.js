import Carousel from 'react-bootstrap/Carousel';
import img from './Assets/Bilkent_University_Crest.svg.png'
import 'bootstrap/dist/css/bootstrap.min.css';
import Image from 'react-bootstrap/Image';

export function Documents() {
    return(
        <div id="#Documents" >
            <Carousel className='a'>
                <Carousel.Item>
                    <Image src={img}/>
                    <Carousel.Caption style={{color: 'black'}}>
                        <h3 >First slide label</h3>
                        <p >Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <Image src={img}/>
                    <Carousel.Caption style={{color: 'black'}}>
                        <h3>Second slide label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <Image src={img}/>
                    <Carousel.Caption style={{color: 'black'}}>
                        <h3>Third slide label</h3>
                        <p>
                            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                        </p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </div>
    );

}
