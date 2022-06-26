import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { useCookies } from 'react-cookie';
import { getUser, sendLogoutReq } from '../services/userService.js';

export default function Home() {

    const [authenticated, setAuthenticated] = useState(false);
    const [loading, setLoading] = useState(false);
    const [user, setUser] = useState(undefined);
    const [cookies] = useCookies(['XSRF-TOKEN']);

    useEffect(() => {
        setLoading(true);
        getUser()
            .then(body => {
                if (body === '') {
                    setAuthenticated(false);
                } else {
                    setUser(JSON.parse(body));
                    setAuthenticated(true);
                }
                setLoading(false);
            });
    }, [setAuthenticated, setLoading, setUser]);

    const login = () => {
        let port = (window.location.port ? ':' + window.location.port : '');
        if (port === ':3000') {
            port = ':8080';
        }
        window.location.href = `//${window.location.hostname}${port}/api/v1/private`;
    }

    const logout = () => {
        sendLogoutReq({
            method: 'POST', 
            credentials: 'include',
            headers: { 'X-XSRF-TOKEN': cookies['XSRF-TOKEN'] }
        });
    }

    const message = user ?
        <h2>Welcome, {user.name}!</h2> :
        <p>Please log in to manage your JUG Tour.</p>;

    const button = authenticated ?
        <div>
            <Button color="link"><Link to="/groups">Manage JUG Tour</Link></Button>
            <br />
            <Button color="link" onClick={logout}>Logout</Button>
        </div> :
        <Button color="primary" onClick={login}>Login</Button>;

    return (
        <>
            <Container fluid>
                {message}
                {button}
            </Container>
        </>
    )
}