import React, { useState } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';

export default function AppNavbar() {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <Navbar color='dark' dark expand="md">
            <NavbarBrand className='me-auto' href='/'>
                CRUD
            </NavbarBrand>
            <NavbarToggler className='me-2' onClick={() => { setIsOpen(!isOpen) }} />
            <Collapse isOpen={isOpen} navbar>
                <Nav className="justify-content-end" style={{ width: "100%" }} navbar>
                    <NavItem>
                        <NavLink href="https://github.com/mischelll">@mischelll</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="https://github.com/mischelll/spring-react-crud">GitHub</NavLink>
                    </NavItem>
                </Nav>
            </Collapse>
        </Navbar>
    );
}
