import PropTypes from 'prop-types';
const MyComponent = ({ name, num, children }) => {
  return (
    <>
      <div>Hello, I'm {name}.</div>
      <div>My favorite number is {num}.</div>
      {children}
    </>
  );
};
MyComponent.defaultProps = {
  //기본값 설정
  name: 'kim',
};
MyComponent.propTypes = {
  //자료형 한정함으로 다른 자료형 넣으면 경고 나타내줌
  name: PropTypes.string,
  num: PropTypes.number.isRequired,
};
export default MyComponent;
