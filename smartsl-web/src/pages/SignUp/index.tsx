import React from 'react'
import { HOME_ROUTE } from '../../routes/constants'
import { Redirect } from 'react-router-dom'
import { Button, Card, Checkbox, Form, Input, Row, Col } from 'antd'
import { isEmpty } from 'lodash'
import useAuthReducer from '../../context/AuthContext/AuthReducer'
import './SignUp.scss'
import bus from '../../assets/bus.jpg';

export default function SignUp(): JSX.Element {
    const {
        state: AuthState,
        methods: { login },
    } = useAuthReducer()

    React.useEffect(() => {
        document.title = `SmartSL | SignUp`
    }, [])

    const formItemLayout = {
        labelCol: {
            xs: { span: 18 },
            sm: { span: 6 },
        },
        wrapperCol: {
            xs: { span: 24 },
            sm: { span: 16 },
        },
    }

    if (isEmpty(AuthState.token))
        return (
            <><div className="site-card-wrapper">
                <Row >
                    <Col span={18} >
                        <Card cover={<img alt="Digis" src={bus} />}
                            bordered={false}>
                        </Card>
                    </Col>
                    <Col span={6}>
                        <Card className="login-card-wrapper"
                            hoverable
                        >
                            <div className={'topics'}>
                                <div className={'title'}>
                                    <label>
                                        Smart SL
                                    </label>
                                </div>
                                <div>
                                    <label className={'sub-title'}>
                                        Public Transport Ticketing System
                                    </label>
                                </div>
                            </div>

                            <Form {...formItemLayout} name="basic" initialValues={{ remember: true }} onFinish={login}>
                                <Form.Item

                                    name="username"
                                    rules={[{ required: true, message: 'Please enter your username!' }]}
                                >
                                    <Input placeholder={'Email/Username'} />
                                </Form.Item>
                                
                                <Form.Item

                                    name="password"
                                    rules={[{ required: true, message: 'Please enter your password!' }]}
                                >
                                    <Input.Password placeholder={'Password'} />
                                </Form.Item>                                
                                <Form.Item name="remember" valuePropName="checked" className={'form-item-remember-me'}>
                                    <div className={'remember-me-wrapper'}>
                                        <Button type="primary" htmlType="submit" loading={AuthState.loginLoading}>
                                            Sign Up
                                        </Button>
                                    </div>
                                </Form.Item>
                                
                            </Form>
                        </Card>
                    </Col>

                </Row>
            </div>
            </>

        )
    else return <Redirect to={HOME_ROUTE} />
}
