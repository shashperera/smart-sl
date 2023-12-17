import React, { useEffect, useState } from 'react'
import { HOME_ROUTE } from '../../routes/constants'
import { Redirect } from 'react-router-dom'
import 'antd/dist/antd.css';
import { Menu, Button, Card, Row, Table, TablePaginationConfig, Col, Dropdown, message, Input, Form, Checkbox } from 'antd'
import './Timetable.scss'

type Props = {}

function handleMenuClick(e: any) {
    message.info('Click on menu item.');
    console.log('click', e);
}

const onFinish = (values: any) => {
    console.log('Success:', values);
};

const onFinishFailed = (errorInfo: any) => {
    console.log('Failed:', errorInfo);
};

const timetables = (
    <Menu onClick={handleMenuClick}>
        <Menu.Item key="1">
            In progress
        </Menu.Item>
        <Menu.Item key="2">
            Collected
        </Menu.Item>
    </Menu>
);

const status = (
    <Menu onClick={handleMenuClick}>
        <Menu.Item key="1">
            In progress        </Menu.Item>
        <Menu.Item key="2">
            Completed        </Menu.Item>

    </Menu>
);

const cols = [
    {
        title: 'Timetable ID',
        dataIndex: 'timetableid',
        sorter: true,
        width: '20%',
    },
    {
        title: 'Date',
        dataIndex: 'date',
        sorter: true,
        width: '20%',
    },
    {
        title: 'Starting Time',
        dataIndex: 'stime',
        sorter: true,
        width: '20%',

    },
    {
        title: 'Ending Time',
        dataIndex: 'etime',
        sorter: true,
        width: '20%',

    },
    {
        title: 'Route no',
        dataIndex: 'route',
        sorter: true,
        width: '15%',
        
    },
    {
        title: 'Vehicle no',
        dataIndex: 'vehicleid',
        sorter: true,
        width: '20%',
        
    },
    {
        title: 'Driver ID',
        dataIndex: 'driverid',
        sorter: true,
        width: '20%',
        
    },
];

export default function Timetables(props: Props): JSX.Element {

    const [pages, SetPages] = useState<TablePaginationConfig>({
        current: 1,
        pageSize: 10,
    });
    const dataSource = [
        {
            key: '1',
            timetableid: 't001',
            date: '2021-11-02',
            stime: '02:05:00',
            etime: '03:50:00',
            driverid: 'd78',
            vehicleid: 'KR5623',
            route: '123',

        },
        {
            key: '2',
            timetableid: 't002',
            date: '2021-10-02',
            stime: '04:05:00',
            etime: '05:50:00',
            driverid: 'd79',
            vehicleid: 'SK5555',
            route: '180',

        },
        {
            key: '3',
            timetableid: 't003',
            date: '2021-10-03',
            stime: '05:08:00',
            etime: '05:55:00',
            driverid: 'd80',
            vehicleid: 'PK5478',
            route: '250',

        },
        {
            key: '4',
            timetableid: 't004',
            date: '2021-10-15',
            stime: '08:25:00',
            etime: '09:55:00',
            driverid: 'd23',
            vehicleid: 'WE4442',
            route: '138',

        },
        
    ];


    return (
        <>

            <div style={{ background: '#ECECEC', padding: '30px' }}>
                <div id="components-dropdow-dropdown-button">

                </div>
                <Row gutter={16}>
                    <Col className="gutter-row" span={3}>
                        <div id="style"><Input placeholder="Vehicle ID"></Input></div>
                    </Col>
                    <Col className="gutter-row" span={3}>
                        <div id="style"><Input placeholder="Date"></Input></div>
                    </Col>
                    <Col className="gutter-row" span={3}>
                        <div id="style"><Input placeholder="Start Time"></Input></div>
                    </Col>
                    <Col className="gutter-row" span={3}>
                        <div id="style"><Input placeholder="End Time"></Input></div>
                    </Col>

                    <Col className="gutter-row" span={5}>
                        <div id="style"><Button type="primary">Search</Button></div>
                    </Col>

                </Row>
                <Row>
                    <Col span={18}>
                        <Card title="Timetables" bordered={false}>
                            <Table
                                columns={cols}
                                pagination={pages}
                                dataSource={dataSource}


                            />                        </Card>
                    </Col>
                    <Col span={6}>
                        <Card title="Schedule timetable" bordered={false}>
                            
                            <Form
                                name="basic"
                                labelCol={{
                                    span: 8,
                                }}
                                wrapperCol={{
                                    span: 16,
                                }}
                                initialValues={{
                                    remember: true,
                                }}
                                onFinish={onFinish}
                                onFinishFailed={onFinishFailed}
                                autoComplete="off"
                            >
                                <Form.Item
                                    label="Date"
                                    name="date"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please input your username!',
                                        },
                                    ]}
                                >
                                    <Input />
                                </Form.Item>

                                <Form.Item
                                    label="Time"
                                    name="time"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please add the time',
                                        },
                                    ]}
                                >
                                    <Input />
                                </Form.Item>
                                <Form.Item
                                    label="Vehicle ID"
                                    name="vehicleid"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please add the vehicle',
                                        },
                                    ]}
                                >
                                    <Input />
                                </Form.Item>
                                
                                <Form.Item
                                    label="Route no"
                                    name="route"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please add a route no',
                                        },
                                    ]}
                                >
                                    <Input />
                                </Form.Item>

                                <Form.Item
                                    name="remember"
                                    valuePropName="checked"
                                    wrapperCol={{
                                        offset: 8,
                                        span: 16,
                                    }}
                                >
                                    <Checkbox>Remember me</Checkbox>
                                </Form.Item>

                                <Form.Item
                                    wrapperCol={{
                                        offset: 8,
                                        span: 16,
                                    }}
                                >
                                    <Button type="primary" htmlType="submit">
                                        Submit
                                    </Button>
                                </Form.Item>
                            </Form>
                        </Card>

                    </Col>

                </Row>
            </div></>
    )
}
