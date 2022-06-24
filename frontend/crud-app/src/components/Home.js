import { Button, Container } from 'reactstrap';
import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <>
            <Container fluid>
                <Button color="link"><Link to="/groups">Manage JUG Tour</Link></Button>
            </Container>
        </>
    )
}