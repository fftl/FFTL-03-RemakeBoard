import React from 'react';
import styled from 'styled-components';

const MyHedaer = styled.div`
    font-size: 32px;
    text-align: center;

    margin-top: 30px;
    //margin-bottom: 30px;

    border: solid 1.5px;
`;

function Header() {
    return <MyHedaer className="MyHedaer">Title</MyHedaer>;
}

export default Header;
