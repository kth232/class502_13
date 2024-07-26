import React from "react";

//양식을 넘겨주지 않고 값만 받아서 ajax로 원격 처리하기 때문에 form 태그에 다른 속성을 넣어줄 필요없음
//출력 담당
const JoinForm = (props) => {
    console.log("pre", Object.getOwnPropertyDescriptor(props));
    console.log("pre", Object.isFrozen(props));

    return (
        <form autoComplete='off'>
            <dl>
                <dt>email</dt>
                <dd>
                    <input type="text" name="email"/>
                </dd>
            </dl>
            <dl>
                <dt>password</dt>
                <dd>
                    <input type="password" name="password"/>
                </dd>
            </dl>
            <dl>
                <dt>confirm password</dt>
                <dd>
                    <input type="password" name="confirmPassword"/>
                </dd>
            </dl>
            <dl>
                <dt>userName</dt>
                <dd>
                    <input type="text" name="userName"/>
                </dd>
            </dl>
            <button type="submit">JOIN</button>
        </form>
    )
};

export default JoinForm;