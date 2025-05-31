import axios from '../../utils/axios'

export function addCourse(data) {
    return axios.post('/admin/course', data)
}

export function getCoursePage(params) {
    return axios.get('/admin/course/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchCourse(ids) {
    return axios.delete('/admin/course/batch', {
        data: ids
    });
} 