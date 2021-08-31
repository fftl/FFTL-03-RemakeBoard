import React from 'react';
import styled from 'styled-components';

const MyFooter = styled.div`
    position: absolute;

    left: 0;
    bottom: 0;
    width: 100%;

    text-align: center;
    padding: 15px 0;

    border: solid 1.5px;
`;

function Footer() {
    return <MyFooter className="MyFooter">Footer</MyFooter>;
}

export default Footer;
