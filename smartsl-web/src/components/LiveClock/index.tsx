import React, { useState, useEffect } from 'react'
import { format as dateFormat } from 'date-fns'

export default function LiveClock(props: LiveClockProps) {
    const { format = 'h:mm:ss a, MMMM do yyyy', interval = 1000, className, style } = props
    const [currentTime, setCurrentTime] = useState(new Date())

    useEffect(() => {
        const tick = setInterval(() => {
            const now = new Date()
            setCurrentTime(now)
        }, interval)

        return () => clearInterval(tick)
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    return (
        <span className={className} style={style}>
            {dateFormat(currentTime, format)}
        </span>
    )
}
type LiveClockProps = {
    className?: string
    format?: string
    filter?: Function
    style?: object
    interval?: number
}
