import React from 'react'
import { HOME_ROUTE } from '../../routes/constants'
import { Redirect } from 'react-router-dom'
import 'antd/dist/antd.css';
import { Menu, Button, Card, Row, Col, Dropdown, message, Input } from 'antd'
import './Routes.scss'

type Props = {}

function handleMenuClick(e: any) {
    message.info('Click on menu item.');
    console.log('click', e);
}

const menu = (
    <Menu onClick={handleMenuClick}>
        <Menu.Item key="1">
            1st menu item
        </Menu.Item>
        <Menu.Item key="2">
            2nd menu item
        </Menu.Item>
        <Menu.Item key="3">
            3rd item
        </Menu.Item>
    </Menu>
);

export default function Routes(props: Props): JSX.Element {
    return (
        <>

            <div style={{ background: '#ECECEC', padding: '30px' }}>
                <div id="components-dropdow-dropdown-button">



                </div>
                <Row gutter={16}>
                    <Col className="gutter-row" span={2.5}>
                        <div id="style"><Dropdown.Button overlay={menu} >
                            Province
                        </Dropdown.Button></div>
                    </Col>
                    <Col className="gutter-row" span={2.5}>
                        <div id="style"><Dropdown.Button overlay={menu}>
                            District
                        </Dropdown.Button></div>
                    </Col>
                    <Col className="gutter-row" span={4}>
                        <div id="style"><Input placeholder="Vehicle Number"></Input></div>
                    </Col>
                    <Col className="gutter-row" span={4}>
                        <div id="style"><Input placeholder="Route ID"></Input></div>
                    </Col>
                    <Col className="gutter-row" span={5}>
                        <div id="style"><Button type="primary">Search</Button></div>
                    </Col>
                </Row>
                <Row gutter={16}>
                    <Col span={16}>
                        <Card title="Map" bordered={false}>
                        <iframe
              src="https://www.google.com/maps/embed?pb=!1m24!1m8!1m3!1d3960.1947926003795!2d79.9379888!3d6.986321!3m2!1i1024!2i768!4f13.1!4m13!3e0!4m5!1s0x3ae2f86426c03e1d%3A0xedcc759e216ad4b5!2sMaladolawattha%2C%20Kadawatha%2C%20Sri%20Lanka!3m2!1d7.0008424!2d79.9566914!4m5!1s0x3ae2f80aec2e475b%3A0x2f6e4aab73a831a3!2sEksath%20Mawatha%2C%20Kadawatha!3m2!1d6.9862763999999995!2d79.94010949999999!5e0!3m2!1sen!2slk!4v1635443047357!5m2!1sen!2slk"
              width="900"
              height="400"
              frameBorder="0"
              style={{ border: 0 }}
              aria-hidden="false"
            /> 
                        </Card>
                       
                    </Col>
                    <Col span={8}>
                        <Card title="Grid" bordered={false}>
                            Card content
                        </Card>
                        
                    </Col>
                    
                </Row>
            </div></>
    )
}
